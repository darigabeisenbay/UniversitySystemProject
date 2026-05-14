package project.models.research;

import java.util.ArrayList;
import java.util.List;

public class ResearchProject {

    private static final int MIN_H_INDEX = 2;

    private String topic;
    private List<ResearchPaper> papers;
    private List<Researcher>    participants;
    private Researcher          supervisor;

    public ResearchProject(String topic, Researcher supervisor) {
        this.topic        = topic;
        this.supervisor   = supervisor;
        this.papers       = new ArrayList<>();
        this.participants = new ArrayList<>();
        this.participants.add(supervisor);
    }


    public String getTopic()                    { return topic; }
    public Researcher getSupervisor()           { return supervisor; }
    public List<ResearchPaper> getPapers()      { return papers; }
    public List<Researcher> getParticipants()   { return participants; }

    public void addParticipant(Object candidate)
            throws NotResearcherException, LowHIndexException {

        if (!(candidate instanceof Researcher)) {
            throw new NotResearcherException(
                candidate.getClass().getSimpleName() +
                " not researcher(not implementing Researcher)"
            );
        }

        Researcher researcher = (Researcher) candidate;

        int hIndex = researcher.getHIndex();
        if (hIndex < MIN_H_INDEX) {
            throw new LowHIndexException(
                "h-index (" + hIndex + ") " +
                "is lower (" + MIN_H_INDEX + ") to participate"
            );
        }

        if (!participants.contains(researcher)) {
            participants.add(researcher);
            System.out.println("Participant was added \"" + topic + "\"");
        } else {
            System.out.println("Participant is already at the project \"" + topic + "\"");
        }
    }
    public void addPaper(ResearchPaper paper) {
        if (!papers.contains(paper)) {
            papers.add(paper);
        }
    }
    public void printInfo() {
        System.out.println("projects: " + topic);
        System.out.println("participants: " + participants.size());
        System.out.println("articles: " + papers.size());
    }
}