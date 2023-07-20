package kishore;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws InterruptedException, IOException {

		QuoraSearch q = new QuoraSearch();
		q.readInputs();
		q.searchSelection();
		q.searchResults();
		q.signIn();
		q.signUpWithEmail();
		q.screenShots();
		q.quit();

	}

}
