package pl.academy.infoshare.sample3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

// TODO Navigate to test to see how this class is called
class ZipFileBrowser {

    static List<String> getMatchingEntries(ZipFile zipFile,
                                           String pattern,
                                           String contains) {
        List<String> result = zipFile.stream()
                                     .filter(ze -> !ze.isDirectory())
                                     .filter(ze -> ze.getName().matches(pattern))
                                     .filter(ze -> containsText(zipFile, ze, contains))
                                     .map(ze -> ze.toString())
                                     .collect(Collectors.toList());
        return result;
    }

    private static boolean containsText(ZipFile zipFile, ZipEntry zipEntry, String contains) {

        if (zipEntry.isDirectory()) {
            return false;
        }

        try (InputStream inputStream = zipFile.getInputStream(zipEntry);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            Optional<String> found = reader.lines()
                                           .filter(l -> l.contains(contains))
                                           .findFirst();
            return found.isPresent();
        } catch (IOException e) {
            return false;
        }
    }
}
