package ice.ice;

public class Issue {
    private int issueID;
    private static int issueCount = 1;
    private User currentUser;
    private Exception exception;

    public Issue(User user, Exception exception){
        this.issueID = issueCount++;
        this.currentUser = user;
        this.exception = exception;
    }

    public int getIssueID() {
        return issueID;
    }
}
