public class Gamestates {

    private static boolean MENU = true, PLAY = false, PAUSE = false, DEAD = false;

    public static boolean isMENU() {
        return MENU;
    }

    public static void setMENU(boolean MENU) {
        Gamestates.MENU = MENU;
    }

    public static boolean isPLAY() {
        return PLAY;
    }

    public static void setPLAY(boolean PLAY) {
        Gamestates.PLAY = PLAY;
    }

    public static boolean isPAUSE() {
        return PAUSE;
    }

    public static void setPAUSE(boolean PAUSE) {
        Gamestates.PAUSE = PAUSE;
    }

    public static boolean isDEAD() {
        return DEAD;
    }

    public static void setDEAD(boolean DEAD) {
        Gamestates.DEAD = DEAD;
    }

}
