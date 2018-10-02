package startup;

public class StaticInner {
    private int  id = 1;
    public static class inner{
        private int fd;
        inner(int x)
        {
            fd = x;
        }
        public int getFd()
        {
            return fd;
        }
    }
    public static inner outerfun()
    {
        return new inner(5);
    }

}
