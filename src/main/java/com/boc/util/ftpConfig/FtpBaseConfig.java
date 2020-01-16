package com.boc.util.ftpConfig;

/**
 * 所有ftp服务器配置项必须继承此类
 * 
 * @author st-wg-hzw14176
 *
 */
public class FtpBaseConfig {

	/**
	 * 上传的ftp地址
	 */
	public String url;
	/**
	 * 上传的端口
	 */
	public int port = 21;
	/**
	 * 上传的ftp用户名
	 */
	public String username;
	/**
	 * 上传的ftp密码
	 */
	public String password;
	/**
	 * 上传的文件存放路径
	 */
	public String remotepath;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRemotepath() {
		return remotepath;
	}
	public void setRemotepath(String remotepath) {
		this.remotepath = remotepath;
	}
	
	

}
