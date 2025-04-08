package programming2.chapter2;

import java.util.Scanner;

class URL {
    private String protocol;
    private String user;
    private String password;
    private String host;
    private String port;
    private String path;

    public URL(String urlString) {
        parseURL(urlString);
    }

    /**
     * Splits the transferred string into the URL components
     * If an error is detected, ‘Error’ is displayed on the console.
     */
    private void parseURL(String urlString) {
    	
        
    }

	@Override
	public String toString() {
		return "URL [protocol=" + protocol + ", user=" + user + ", password=" + password + ", host=" + host + ", port="
				+ port + ", path=" + path + "]";
	}


}

public class URLAnalysis {
    public static String readString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        String s = scanner.nextLine();
        scanner.close();
        return s;
    }
    public static void main(String[] args) {
        String s = readString("URL: ");
        URL url = new URL(s);         
        System.out.println(url);
    }
}