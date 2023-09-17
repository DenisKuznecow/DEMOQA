package dataproviders;



import baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uploadanddownloadpage.UploadAndDownloadPage;
public class DataProviders extends BaseClass {

    @DataProvider(name="Upload files")
    public static Object [][] dataProvider(){
        return new Object[][]{
                {"C:\\Users\\Юзверь\\Desktop\\images.png"},


        };
    }
    @Test(dataProvider = "Upload files")
    public void uploadFilesTest(String fileToUpload)  {

        Assert.assertEquals(methods.getTitleName(),"Upload and Download");
        UploadAndDownloadPage.clickChooseFile(fileToUpload);
        waitTime();
    }
}