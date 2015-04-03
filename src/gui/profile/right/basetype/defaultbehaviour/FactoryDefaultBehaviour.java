package gui.profile.right.basetype.defaultbehaviour;

/**
 */
public class FactoryDefaultBehaviour {
    static public enum Arg { OUTPUT, NO_OUTPUT }
    static public I_DefaultBehaviour build(Arg arg) {
        switch (arg) {
            case OUTPUT:
                return OutputForDefault.instance;
            case NO_OUTPUT:
                return NoOutputForDefault.instance;
            default:
                return null;
        }
    }

}
