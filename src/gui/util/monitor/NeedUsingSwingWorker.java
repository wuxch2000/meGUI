package gui.util.monitor;

/**
 * 使用方法：<br/>
 * 需要多线程的类implements本接口。 函数doInBackground和done分别为后台运行的操作和运行完毕的操作。<br/>
 * 示例： <br/>
 * <code>
 * SwingWorkerGui worker = new SwingWorkerGui(this); <br/>
 * worker.execute();<br/>
 * </code>
 *
 * @author 吴晓春
 *
 */
public interface NeedUsingSwingWorker {
	public void done() throws Exception;

	public void doInBackground() throws Exception;
}
