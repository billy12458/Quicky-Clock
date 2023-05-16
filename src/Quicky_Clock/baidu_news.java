package Quicky_Clock;
import java.awt.Font;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.*;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
@SuppressWarnings("all")class baidu_news implements Runnable{
	public static final JLabel LABEL1=MainFrame.lblNewLabel_3;
	static List<org.jsoup.nodes.Element> elelist1=Collections.synchronizedList(new ArrayList<>());
	private static final boolean LOG1=properties_1.uselog;
	private static final void getnews() throws Exception{
		CloseableHttpClient httpClient = HttpClients.createDefault();// ����HttpClientʵ��
		HttpGet httpGet = new HttpGet("https://news.baidu.com/");// ����httpgetʵ��
	    RequestConfig config = RequestConfig.custom().setConnectTimeout(10000,TimeUnit.MILLISECONDS)//�������ӳ�ʱʱ��10���ӣ���λ����
	    .build();
	    httpGet.setConfig(config);httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; W��) Gecko/20100101 Firefox/59.0");
	    CloseableHttpResponse response = httpClient.execute(httpGet);// ��������ͷ��ϢUser-Agentģ�������,ִ��get����
	    HttpEntity entity = response.getEntity();// ��ȡ����ʵ��
	    String content = EntityUtils.toString(entity, "utf-8"); // ʵ������ݣ������ʽΪutf-8��
	    org.jsoup.nodes.Document doc = Jsoup.parse(content); // ������ҳ �õ��ĵ�����    
	    org.jsoup.select.Elements hrefElements = doc.select("a[href]");// ѡ�����е�aԪ��
	    for (org.jsoup.nodes.Element e : hrefElements){
	    	elelist1.add(e);
	    }Iterator<Element> it1=elelist1.iterator();
	    while(it1.hasNext()){
	    	if(it1.next().text().length()<11||it1.next().text().contains("��������")){it1.remove();}
	    }
	}@Override public void run(){
		try{getnews();
			for(org.jsoup.nodes.Element e : elelist1){
		    	LABEL1.setText(new String(e.text().getBytes(),"UTF-8"));
		    	Thread.sleep(10000);
		    }
		}catch(Exception interruptedparioException){
			UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("����", Font.PLAIN, 16)));
			JOptionPane.showMessageDialog(null, "��ȡ�ٶ�����ʧ�ܣ�");
		}
	}
}