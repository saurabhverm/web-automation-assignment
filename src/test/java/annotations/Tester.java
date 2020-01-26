package annotations;

public enum Tester {
 
	Saurabh("Saurabh Verma");

    public String authorName;
    Tester(String authorName)
    {
        this.authorName=authorName;
    }

    public String toString() {
        return this.authorName;
    }
}
