package com.example.pokedex.utilities;

import com.example.pokedex.models.OutputFormat;

/**
 * ConsoleOutputUtility class is responsible for displaying Pokémon information in different output formats
 * on the console. It uses the specified output format and the corresponding generator to produce the output.
 */
public class ConsoleOutputUtility {
    OutputFormat outputFormat;
    MultipleFormatGenerator formatsGenerator;

    /**
     * Constructs a ConsoleOutputUtility object with the specified output format and format generator.
     *
     * @param outputFormat     The desired output format (TEXT, HTML, CSV).
     * @param formatsGenerator The generator for creating different output formats.
     */
    public ConsoleOutputUtility(OutputFormat outputFormat, MultipleFormatGenerator formatsGenerator) {
        this.outputFormat = outputFormat;
        this.formatsGenerator = formatsGenerator;
    }

    /**
     * Generates and displays the output based on the specified output format.
     */
    public void makeOutput() {
        if (this.outputFormat == OutputFormat.TEXT) {
            System.out.println(formatsGenerator.generateHumanReadableText());
        } else if (this.outputFormat == OutputFormat.HTML) {
            System.out.println(formatsGenerator.generateHTML());
        } else if (this.outputFormat == OutputFormat.CSV) {
            System.out.println(formatsGenerator.generateCSV());
        }
    }
}
