package project.models.research;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResearchPaper {

    private int id;
    private String title;
    private List<Researcher> authors;
    private String journal;
    private int pages;
    private int citations;
    private Date publishDate;
    private String doi;

    public ResearchPaper(int id, String title, String journal,
                         int pages, int citations, Date publishDate, String doi) {
        this.id          = id;
        this.title       = title;
        this.journal     = journal;
        this.pages       = pages;
        this.citations   = citations;
        this.publishDate = publishDate;
        this.doi         = doi;
        this.authors     = new ArrayList<>();
    }


    public int getId()               { return id; }
    public String getTitle()         { return title; }
    public List<Researcher> getAuthors() { return authors; }
    public String getJournal()       { return journal; }
    public int getPages()            { return pages; }
    public int getCitations()        { return citations; }
    public Date getPublishDate()     { return publishDate; }
    public String getDoi()           { return doi; }


    public void addAuthor(Researcher researcher) {
        if (!authors.contains(researcher)) {
            authors.add(researcher);
        }
    }

    @Override
    public String toString() {
        return String.format(
            "[%d] \"%s\" | %s | citations: %d | pages: %d | doi: %s | date: %s",
            id, title, journal, citations, pages, doi, publishDate
        );
    }
}