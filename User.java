public abstract class User {
    protected String name,email;
    public User(String n,String e){ name=n; email=e; }
    public abstract void dashboard();
}