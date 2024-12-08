package ice.ice;

import java.util.ArrayList;

public class IT {
    private ArrayList<Issue> issues;

    public IT() {
        this.issues = new ArrayList<>();
    }

    public void addIssue(Issue issue){
        issues.add(issue);
    }

    public void removeIssue(){

    }
}
