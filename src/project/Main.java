package project;

import project.models.communication.Complaint;
import project.models.communication.News;
import project.models.communication.Rating;
import project.models.communication.SortType;
import project.models.course.Course;
import project.models.course.CourseRegistration;
import project.models.infrastructure.Database;
import project.models.infrastructure.ManagerType;
import project.models.infrastructure.StatusType;
import project.models.infrastructure.TeacherTitle;
import project.models.research.LowHIndexException;
import project.models.research.NotResearcherException;
import project.models.research.ResearchPaper;
import project.models.research.ResearchProject;
import project.models.research.ResearchService;
import project.models.research.Researcher;
import project.models.user.Manager;
import project.models.user.Student;
import project.models.user.Teacher;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Starting KBTU System Test ===\n");

        Database db = Database.getInstance();

        Student dariga = new Student(1, "d_beisenbay", "pass123", "Dariga Beisenbay",
                "d.beisenbay@kbtu.kz", 0.0, 2, 0);

        Teacher talgat = new Teacher(101, "n_talgat", "root", "keencheek",
                "keencheek@gmail.com", 500000.0, "IT", TeacherTitle.PROFESSOR);

        Manager manager = new Manager("M001", "admin", "admin", "Alibi Adil",
                "a.adil@kbtu.kz", 300000.0, "OR", ManagerType.REGISTRAR);

        db.addUser(dariga);
        db.addUser(talgat);
        db.addUser(manager);

        Course oop = new Course(1, "Object-Oriented Programming", 3);
        manager.addCourse(oop);

        System.out.println("--- Testing Teacher Assignment ---");
        manager.assignTeacher(oop, talgat);
        System.out.println("Teachers of OOP: " + oop.getTeachers());

        System.out.println("\n--- Testing Course Registration ---");
        CourseRegistration reg = dariga.registerCourse(oop);
        manager.addRegistration(reg);
        manager.approveRegistration(reg);
        dariga.addCourse(oop);

        System.out.println("\n--- Testing Grading System ---");
        talgat.putMark(dariga, oop, 25.5, 28.0, 35.0);
        System.out.println("Student GPA after grade: " + dariga.getGpa());
        dariga.viewTranscript();

        System.out.println("\n--- Testing Complaints & News ---");
        Complaint badWiFi = new Complaint(dariga, "WiFi in 4th floor is slow");
        manager.addComplaintToReview(badWiFi);
        manager.viewComplaints();
        manager.resolveComplaint(badWiFi, StatusType.RESOLVED);

        News examNews = new News(1245, "Exam Notification", "Exams start on May 20th");
        manager.addNews(examNews);
        System.out.println("News list: " + manager.getNewsList());

        System.out.println("\n--- Testing Manager Reports ---");
        manager.generateReport(oop);

        System.out.println("\nStudents by GPA:");
        List<Student> sortedStudents = manager.viewStudentsByGpa(oop);
        for (Student s : sortedStudents) {
            System.out.println(s.getUsername() + ": " + s.getGpa());
        }

        System.out.println("\n--- Testing Teacher Ratings ---");
        Rating r1 = new Rating(5, "Best teacher ever!", dariga);
        talgat.getRatings().add(r1);
        System.out.println("Teacher ratings: " + manager.viewTeacherRatings(talgat));

        System.out.println("\n--- Testing Researcher Logic ---");

        Date now = new Date();

        ResearchPaper paper1 = new ResearchPaper(
                1, "Deep Learning in Education", "IEEE",
                12, 15, now, "10.1109/edu.2024.001");
        ResearchPaper paper2 = new ResearchPaper(
                2, "AI-based GPA Prediction", "Springer",
                8, 3, now, "10.1007/edu.2024.002");
        ResearchPaper paper3 = new ResearchPaper(
                3, "NLP for Student Feedback", "Elsevier",
                10, 9, now, "10.1016/edu.2024.003");
        ResearchPaper weakPaper = new ResearchPaper(
                4, "Intro to Java", "Local Journal",
                4, 1, now, "10.0001/local.2024.001");

        Researcher seniorResearcher = new Researcher() {
            private final List<ResearchPaper> papers = List.of(paper1, paper2, paper3);

            @Override
            public int getHIndex() {
                List<Integer> sorted = papers.stream()
                        .map(ResearchPaper::getCitations)
                        .sorted(Comparator.reverseOrder())
                        .toList();
                int h = 0;
                for (int i = 0; i < sorted.size(); i++) {
                    if (sorted.get(i) >= i + 1) h = i + 1;
                    else break;
                }
                return h;
            }

            @Override
            public void printPapers(SortType sortType) {
                System.out.println("Papers of seniorResearcher:");
                papers.forEach(p -> System.out.println("  " + p));
            }

            @Override
            public List<ResearchPaper> getPapers() { return papers; }

            @Override
            public String toString() { return "SeniorResearcher(hIndex=" + getHIndex() + ")"; }
        };

        Researcher juniorResearcher = new Researcher() {
            private final List<ResearchPaper> papers = List.of(weakPaper);

            @Override
            public int getHIndex() { return 1; }

            @Override
            public void printPapers(SortType sortType) {
                System.out.println("Papers of juniorResearcher:");
                papers.forEach(p -> System.out.println("  " + p));
            }

            @Override
            public List<ResearchPaper> getPapers() { return papers; }

            @Override
            public String toString() { return "JuniorResearcher(hIndex=1)"; }
        };

        paper1.addAuthor(seniorResearcher);
        paper2.addAuthor(seniorResearcher);
        paper3.addAuthor(seniorResearcher);
        weakPaper.addAuthor(juniorResearcher);

        ResearchProject project = new ResearchProject("AI in Education", seniorResearcher);
        project.addPaper(paper1);
        project.addPaper(paper2);
        project.addPaper(paper3);

        System.out.println("\n[1] Adding juniorResearcher (h-index=1, minimum=2):");
        try {
            project.addParticipant(juniorResearcher);
        } catch (LowHIndexException e) {
            System.out.println("LowHIndexException: " + e.getMessage());
        } catch (NotResearcherException e) {
            System.out.println("NotResearcherException: " + e.getMessage());
        }

        System.out.println("\n[2] Adding a plain Teacher (does not implement Researcher):");
        try {
            project.addParticipant(talgat);
        } catch (NotResearcherException e) {
            System.out.println("NotResearcherException: " + e.getMessage());
        } catch (LowHIndexException e) {
            System.out.println("LowHIndexException: " + e.getMessage());
        }
        System.out.println("\n[3] Adding seniorResearcher again (already a participant):");
        try {
            project.addParticipant(seniorResearcher);
        } catch (NotResearcherException | LowHIndexException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        project.printInfo();

        System.out.println("\n[4] ResearchService:");
        ResearchService service = new ResearchService();
        service.registerResearcher(seniorResearcher);
        service.registerResearcher(juniorResearcher);
        service.printAllPapers(SortType.BY_CITATIONS);
        service.printAllPapers(SortType.BY_PAGES);
        service.getTopCitedResearcher();

        System.out.println("\n[5] seniorResearcher printPapers(BY_DATE):");
        seniorResearcher.printPapers(SortType.BY_DATE);

    }
}