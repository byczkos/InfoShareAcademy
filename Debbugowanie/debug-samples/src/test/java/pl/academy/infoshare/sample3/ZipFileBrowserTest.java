package pl.academy.infoshare.sample3;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;

public class ZipFileBrowserTest {

    private Path path = Paths.get("src/test/resources/zip", "sample-1.zip");
    private ZipFile zipFile;

    @Before
    public void setUp() throws Exception {
        zipFile = new ZipFile(path.toFile());
    }

    @Test
    public void findsTextFilesContainingText() {

        List<String> matchingEntries = ZipFileBrowser
            .getMatchingEntries(zipFile, ".*txt", "Line 1");

        assertThat(matchingEntries)
            .containsSequence("1.txt", "1/1-1.txt");
    }

    @Test
    public void findsCsvFilesContainingText() {

        List<String> matchingFiles = ZipFileBrowser
            .getMatchingEntries(zipFile, ".*csv", "22");

        assertThat(matchingFiles)
            .containsSequence("1/1-2/1-1-2.csv");
    }

}