public class AppStart {
    public static void main(String[] args) {
        System.out.println("AppStart.main()");
        Display.Screen s = new Display.Screen();
        s.startGthread();
    }
}
