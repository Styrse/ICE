package ice.ice;

import java.util.ArrayList;

public class IT {
    private ArrayList<Issue> issues;

    public IT(ArrayList<Issue> issues) {
        this.issues = issues;
    }

    public void addIssue(Issue issue){
        issues.add(issue);
    }

    public void removeIssue(){

    }
}
