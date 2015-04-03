package gui.profile.right.basetype.format;

/**
 */
public class FactoryArgOutputFormat {
        static public enum Arg { EQUAL, SPACE }
    static public I_ArgOutputFormat build(Arg arg) {
        switch (arg) {
            case EQUAL:
                return OutputUsingEqual.instance;
            case SPACE:
                return OutputUsingSpace.instance;
            default:
                return null;
        }
    }
}
