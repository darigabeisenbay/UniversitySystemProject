package project.models.research;

import project.models.communication.SortType;

import java.util.List;

public interface Researcher {

    int getHIndex();
    void printPapers(SortType sortType);
    List<ResearchPaper> getPapers();
}