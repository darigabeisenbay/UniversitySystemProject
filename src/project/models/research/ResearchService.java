package project.models.research;

import project.models.communication.SortType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ResearchService {

    private List<Researcher> allResearchers;

    public ResearchService() {
        this.allResearchers = new ArrayList<>();
    }

    public void registerResearcher(Researcher researcher) {
        if (!allResearchers.contains(researcher)) {
            allResearchers.add(researcher);
        }
    }
    public void printAllPapers(SortType sortType) {
        List<ResearchPaper> allPapers = new ArrayList<>();
        for (Researcher r : allResearchers) {
            for (ResearchPaper paper : r.getPapers()) {
                if (!allPapers.contains(paper)) {
                    allPapers.add(paper);
                }
            }
        }
        switch (sortType) {
            case BY_CITATIONS:
                allPapers.sort(Comparator.comparingInt(ResearchPaper::getCitations).reversed());
                break;
            case BY_PAGES:
                allPapers.sort(Comparator.comparingInt(ResearchPaper::getPages).reversed());
                break;
            case BY_DATE:
            default:
                allPapers.sort(Comparator.comparing(ResearchPaper::getPublishDate).reversed());
                break;
        }

        System.out.println("\n── All articles [sorted: " + sortType + "] ──");
        if (allPapers.isEmpty()) {
            System.out.println("  (no articles)");
        }
        for (ResearchPaper paper : allPapers) {
            System.out.println("  " + paper);
        }
    }
    public Researcher getTopCitedResearcher() {
        if (allResearchers.isEmpty()) return null;

        Researcher top     = null;
        int        maxCite = -1;

        for (Researcher r : allResearchers) {
            int totalCitations = 0;
            for (ResearchPaper paper : r.getPapers()) {
                totalCitations += paper.getCitations();
            }
            if (totalCitations > maxCite) {
                maxCite = totalCitations;
                top     = r;
            }
        }

        System.out.println("\n── top cited researcher ──");
        System.out.println("  " + top + " | number of citations: " + maxCite);
        return top;
    }
}