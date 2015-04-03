package gui.profile.right.basetype;

import gui.I_GUI;
import config.encode.EncodeProfile;

/**
 *
 * 基本的配置接口
 *
 * @author 吴晓春
 *
 *
 *
 */
public interface I_ConfigItem extends I_GUI {
	/**
	 *
	 * 支持从XML配置文件中读取需要的内容
	 *
	 * @param file
	 *
	 *            对应的配置文件
	 *
	 */
	public void updateFromFile(EncodeProfile file);

	/**
	 *
	 * 支持从XML配置文件中记录内容
	 *
	 * @param file
	 *
	 *            对应的配置文件
	 *
	 */
	public void updateToFile(EncodeProfile file);

	/**
	 * @return 当前配置项对应的命令行参数，如果是缺省参数，那么返回""
	 */
	public String toCmdLineArg();

	/**
	 * 设置相应配置项为缺省值
	 */
	public void setDefault();

}
