package gui.profile.right.basetype.defaultbehaviour;

/**
 * Created by IntelliJ IDEA.
 * User: 吴晓春
 * Date: 11-2-15
 * Timex: 下午4:31
 */
class OutputForDefault implements I_DefaultBehaviour{
    static OutputForDefault instance = new OutputForDefault();
    @Override
    public boolean noOutputForDefault() {
        return false;
    }
}
