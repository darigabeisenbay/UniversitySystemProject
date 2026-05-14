package project.models.user;

import project.models.communication.Complaint;
import project.models.communication.News;
import project.models.communication.Rating;
import project.models.course.Course;
import project.models.course.CourseRegistration;
import project.models.infrastructure.ManagerType;
import project.models.infrastructure.StatusType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Manager extends Employee {
    private static final long serialVersionUID = 1L;

    private ManagerType type;

    private List<CourseRegistration> registrations;
    private List<Course> courses;
    private List<Complaint> complaints;
    private List<News> newsList;

    public Manager(String id, String username, String password, String fullName,
                   String email, double salary, String department, ManagerType type) {
        super(id, username, password, fullName, email, salary, department);
        this.type = type;
        this.registrations = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.complaints = new ArrayList<>();
        this.newsList = new ArrayList<>();
    }



    public void approveRegistration(CourseRegistration registration) {
        registration.setStatus(StatusType.RESOLVED);
        System.out.println("Registration approved for: " + registration.getStudent().getUsername());
    }

    public void rejectRegistration(CourseRegistration registration) {
        registration.setStatus(StatusType.REJECTED);
        System.out.println("Registration rejected for: " + registration.getStudent().getUsername());
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            System.out.println("Course added: " + course.getName());
        }
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        System.out.println("Course removed: " + course.getName());
    }

    public List<CourseRegistration> getApprovedRequests() {
        return registrations.stream()
                .filter(r -> r.getStatus() == StatusType.RESOLVED)
                .collect(Collectors.toList());
    }



    public void assignTeacher(Course course, Teacher teacher) {
        course.addTeacher(teacher);
        teacher.addCourse(course);
        System.out.println("Teacher " + teacher.getUsername()
                + " assigned to course: " + course.getName());
    }


    public void generateReport(Course course) {
        System.out.println("=== Academic Performance Report: " + course.getName() + " ===");
        List<Student> students = course.getStudents();
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
            return;
        }
        double totalGpa = 0;
        for (Student s : students) {
            System.out.println(s.getUsername() + " | GPA: " + s.getGpa());
            totalGpa += s.getGpa();
        }
        System.out.printf("Average GPA: %.2f | Students: %d%n", (totalGpa / students.size()), students.size());
    }

    public void manageNews(News news) {
        if (!newsList.contains(news)) {
            newsList.add(news);
            System.out.println("News published: " + news.getTitle());
        }
    }

    public void removeNews(News news) {
        newsList.remove(news);
        System.out.println("News removed: " + news.getTitle());
    }

    public List<News> getNewsList() {
        return newsList;
    }


    public List<Student> viewStudentsByGpa(Course course) {
        return course.getStudents().stream()
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .collect(Collectors.toList());
    }



    public List<Student> viewStudentsAlphabetically(Course course) {
        return course.getStudents().stream()
                .sorted(Comparator.comparing(User::getFullName))
                .collect(Collectors.toList());
    }

    public List<Teacher> viewTeachers(Course course) {
        return course.getTeachers();
    }


    public List<Rating> viewTeacherRatings(Teacher teacher) {
        return teacher.getRatings();
    }



    public List<Complaint> viewComplaints() {
        System.out.println("=== Complaints ===");
        for (Complaint c : complaints) {
            System.out.println(c);
        }
        return complaints;
    }

    public void resolveComplaint(Complaint complaint, StatusType status) {
        complaint.setStatus(status);
        System.out.println("Complaint resolved with status: " + status);
    }

    public void addComplaintToReview(Complaint complaint) {
        if (!complaints.contains(complaint)) {
            complaints.add(complaint);
        }
    }


    public void generateSchedule(Course course) {
        System.out.println("Schedule generation for course: " + course.getName());
        System.out.println("Schedule generated successfully.");
    }



    public ManagerType getType() { return type; }
    public void setType(ManagerType type) { this.type = type; }

    public List<Course> getCourses() { return courses; }
    public List<CourseRegistration> getRegistrations() { return registrations; }

    public void addRegistration(CourseRegistration registration) {
        registrations.add(registration);
    }

    @Override
    public String getRole() {
        return "Manager";
    }

    @Override
    public String toString() {
        return super.toString() +
                ", type=" + type;
    }

    public void addNews(News news) {
        if (news == null) return;
        if (!newsList.contains(news)) {
            news.publish();
            newsList.add(news);
            System.out.println("News added: " + news.getTitle());
        } else {
            System.out.println("News already exists: " + news.getTitle());
        }
    }
}
