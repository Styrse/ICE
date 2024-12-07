package ice.ice;

public class Issue {
    private int issueID;
    private static int issueCount = 1;
    private User user;

    public Issue(User user){
        this.issueID = issueCount++;
        this.user = user;
    }

    public int getIssueID() {
        return issueID;
    }
}
