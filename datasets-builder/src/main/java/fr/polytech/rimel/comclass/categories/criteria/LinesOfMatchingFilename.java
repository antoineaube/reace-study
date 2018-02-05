package fr.polytech.rimel.comclass.categories.criteria;

import org.repodriller.domain.Modification;

import java.util.regex.Pattern;

public class LinesOfMatchingFilename implements ClassificationCriterion {

    private final Pattern filenamePattern;

    public LinesOfMatchingFilename(Pattern filenamePattern) {
        this.filenamePattern = filenamePattern;
    }

    @Override
    public long countMatchingLines(Modification fileModification) {
        if (filenamePattern.matcher(fileModification.getNewPath()).matches()) {
            return fileModification.getAdded() + (long) fileModification.getRemoved();
        }

        return 0;
    }
}
