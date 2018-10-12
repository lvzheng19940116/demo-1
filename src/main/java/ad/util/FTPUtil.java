package ad.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import sun.net.TelnetInputStream;
import sun.net.ftp.FtpClient;
import sun.net.ftp.FtpProtocolException;

public class FTPUtil {

	private String localfilename;

	private String remotefilename;

	private FtpClient ftpClient;

	public void connectServer(String ip, int port, String user, String password, String path)
			throws FtpProtocolException

	{

		try {

			ftpClient = FtpClient.create();

			try {

				SocketAddress addr = new InetSocketAddress(ip, port);

				ftpClient.connect(addr);

				ftpClient.login(user, password.toCharArray());

				System.out.println("login success!");

				if (path.length() != 0) {

					// 把远程系统上的目录切换到参数path所指定的目录

					ftpClient.changeDirectory(path);

				}

			} catch (FtpProtocolException e) {

				// TODO Auto-generated catch block

				e.printStackTrace();

			}

		} catch (IOException ex) {

			ex.printStackTrace();

			throw new RuntimeException(ex);

		}

	}

	public void closeConnect()

	{

		try

		{

			ftpClient.close();

			System.out.println("disconnect success");

		} catch (IOException ex)

		{

			System.out.println("not disconnect");

			ex.printStackTrace();

			throw new RuntimeException(ex);

		}

	}

	public boolean upload(String localFile, String remoteFile) throws FtpProtocolException

	{

		this.localfilename = localFile;

		this.remotefilename = remoteFile;

		OutputStream os = null;

		FileInputStream is = null;

		boolean flage = false;

		try

		{

			// 将远程文件加入输出流中

			os = (OutputStream) ftpClient.putFileStream(this.remotefilename, true);

			// 获取本地文件的输入流

			File file_in = new File(this.localfilename);

			is = new FileInputStream(file_in);

			// 创建一个缓冲区

			byte[] bytes = new byte[1024];

			int c;

			while ((c = is.read(bytes)) != -1)

			{

				os.write(bytes, 0, c);

			}

			System.out.println("upload success");

			flage = true;

			// return true;

		} catch (IOException ex)

		{

			System.out.println("not upload");

			ex.printStackTrace();

			flage = false;

			throw new RuntimeException(ex);

		} finally

		{

			try

			{

				if (is != null)

				{

					is.close();

				}

			} catch (IOException e)

			{

				e.printStackTrace();

			} finally

			{

				try

				{

					if (os != null)

					{

						os.close();

					}

				} catch (IOException e)

				{

					e.printStackTrace();

				}

			}

		}

		return flage;

	}

	public void download(String remoteFile, String localFile) throws FtpProtocolException

	{

		TelnetInputStream is = null;

		FileOutputStream os = null;

		try

		{

			// 获取远程机器上的文件filename，借助TelnetInputStream把该文件传送到本地。

			is = (TelnetInputStream) ftpClient.getFileStream(remoteFile);

			File file_in = new File(localFile);

			os = new FileOutputStream(file_in);

			byte[] bytes = new byte[1024];

			int c;

			while ((c = is.read(bytes)) != -1)

			{

				os.write(bytes, 0, c);

			}

			System.out.println("download success");

		} catch (IOException ex)

		{

			System.out.println("not download");

			ex.printStackTrace();

			throw new RuntimeException(ex);

		} finally

		{

			try

			{

				if (is != null)

				{

					is.close();

				}

			} catch (IOException e)

			{

				e.printStackTrace();

			} finally

			{

				try

				{

					if (os != null)

					{

						os.close();

					}

				} catch (IOException e)

				{

					e.printStackTrace();

				}

			}

		}

	}

	/*public static void main(String agrs[]) {
		FTPUtil ftp = new FTPUtil();
		String ftpIP = "127.0.0.1";
		String user = "chenchao";
		String pass = "123456";
		int port = 21;
		String http = "ftp上传路径";
		String localfile = "D:/ceshi.jpg";
		String remotefile = "ftp上传路径/javaftp测试.jpg";

		try {
			ftp.connectServer(ftpIP, port, user, pass, http);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			ftp.upload(localfile, remotefile); // 上传
		} catch (FtpProtocolException e) {
			e.printStackTrace();
		}
		ftp.closeConnect();
	}*/

}