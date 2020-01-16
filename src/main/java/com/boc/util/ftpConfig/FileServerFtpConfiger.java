package com.boc.util.ftpConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 文件管理服务器ftp配置
 * @author st-wg-hzw14176
 *
 */
@ConfigurationProperties(prefix="ftp.fileftpserver")
@Component
public class FileServerFtpConfiger extends FtpBaseConfig{
	

}
