package hello.servlet.basic.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		printStartLine(request);
		printHeaders(request);
		printHeaderUtils(request);
		printEtc(request);
	}

	// start line 情報
	private void printStartLine(HttpServletRequest request) {
		System.out.println("--- REQUEST-LINE - start ---");
		System.out.println("request.getMethod() = " + request.getMethod()); // GET
		System.out.println("request.getProtocal() = " + request.getProtocol()); // HTTP/1.1
		System.out.println("request.getScheme() = " + request.getScheme()); // http
		// http://localhost:8080/request-header
		System.out.println("request.getRequestURL() = " + request.getRequestURL());
		// /request-test
		System.out.println("request.getRequestURI() = " + request.getRequestURI());
		// username=hi
		System.out.println("request.getQueryString() = " + request.getQueryString());
		System.out.println("request.isSecure() = " + request.isSecure()); // https使用
		System.out.println("--- REQUEST-LINE - end ---");
		System.out.println();
	}

	private void printHeaders(HttpServletRequest request) {
		System.out.println("--- Headers - start ---");

		request.getHeaderNames().asIterator()
				.forEachRemaining(headerName -> System.out.println(headerName + " : " + headerName));

		System.out.println("--- Headers - end ---");
		System.out.println();
	}

	// Header 便利な検索
	private void printHeaderUtils(HttpServletRequest request) {
		System.out.println("--- Header 便利な検索　start ---");
		System.out.println("[Host 検索]");
		System.out.println("request.getServerName() = " + request.getServerName()); // Host Header
		System.out.println("request.getServerPort() = " + request.getServerPort()); // Host Header
		System.out.println();
		System.out.println("[Accept-Language 便利な検索]");
		request.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = " + locale));
		System.out.println("request.getLocale() = " + request.getLocale());
		System.out.println();
		System.out.println("[cookie 便利な検索]");
		if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				System.out.println(cookie.getName() + ": " + cookie.getValue());
			}
		}
		System.out.println();
		System.out.println("[Content 便利な検索]");
		System.out.println("request.getContentType() = " + request.getContentType());
		System.out.println("request.getContentLength() = " + request.getContentLength());
		System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
		System.out.println("--- Header 便利な検索 end ---");
		System.out.println();
	}

	//その他検索
	private void printEtc(HttpServletRequest request) {
		System.out.println("--- その他検索 start ---");
		System.out.println("[Remote 情報]");
		System.out.println("request.getRemoteHost() = " + request.getRemoteHost()); //
		System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr()); //
		System.out.println("request.getRemotePort() = " + request.getRemotePort()); //
		System.out.println();
		System.out.println("[Local 情報]");
		System.out.println("request.getLocalName() = " + request.getLocalName()); //
		System.out.println("request.getLocalAddr() = " + request.getLocalAddr()); //
		System.out.println("request.getLocalPort() = " + request.getLocalPort()); //
		System.out.println("--- その他検索 end ---");
		System.out.println();
	}
}
