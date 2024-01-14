package com.example.pokedex.utilities;
/**
 * The MultipleFormatGenerator interface defines methods for generating Pokemon information
 * in various output formats, including human-readable text, HTML, and CSV.
 */
public interface MultipleFormatGenerator {
    /**
     * Generates an HTML representation of the Pokemon information.
     *
     * @return The HTML representation.
     */
    public String generateHTML();

    /**
     * Generates a CSV representation of the Pokemon information.
     *
     * @return The CSV representation.
     */
    public String generateCSV();

    /**
     * Generates a human-readable text representation of the Pokemon information.
     *
     * @return The human-readable text representation.
     */
    public String generateHumanReadableText();
}
