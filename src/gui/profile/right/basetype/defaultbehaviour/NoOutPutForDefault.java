package gui.profile.right.basetype.defaultbehaviour;

/**
 * Created by IntelliJ IDEA.
 * User: 吴晓春
 * Date: 11-2-15
 * Timex: 下午4:31
 */
class NoOutputForDefault implements I_DefaultBehaviour{

    static NoOutputForDefault instance = new NoOutputForDefault();

    @Override
    public boolean noOutputForDefault() {
        return true;
    }
}
