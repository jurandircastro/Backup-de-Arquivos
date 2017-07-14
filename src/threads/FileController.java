package threads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileController extends Thread {
	private File saida;
	private File destino;

	public FileController(File saida, File destino){
		this.saida = saida;
		this.destino = destino;
		new Thread(this).start();
	}

	public void run(){
		try {
			copiaDiretorio(saida, destino);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copiaDiretorio(File saida, File destino) throws IOException {
		if (saida.isDirectory()) {
			if (!destino.exists()) {
				destino.mkdir();
			} 
			String[] arquivos = saida.list();
			
			for (int i = 0; i < arquivos.length; i++) {
				copiaDiretorio(new File(saida, arquivos[i]), new File(destino, arquivos[i]));
			}
		} else {
			copiaArquivo(saida, destino);
		}
	}

	private void copiaArquivo(File saida, File destino) throws IOException {
		InputStream in = new FileInputStream(saida);
		OutputStream out = new FileOutputStream(destino);
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}
}
