package ShareDataBrowser.Browser;

public interface BrowserServiceInterface
{
    //metoda ce deschide browserul


    //setul de reguli
    void openBrowser(); //metoda ce nu returneaza nimic
    Object browserOptions();  //metoda ce returneaza un obiect (la general), deoarece interfata este implementata in alte clase care vor urma regulile de aici

}
