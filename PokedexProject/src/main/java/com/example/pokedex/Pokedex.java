package com.example.pokedex;


import com.example.pokedex.models.DataSource;
import com.example.pokedex.models.OutputFormat;
import com.example.pokedex.models.Pokemon;
import com.example.pokedex.services.HTTPData;
import com.example.pokedex.services.SQLData;
import com.example.pokedex.utilities.ConsoleOutputUtility;
import com.example.pokedex.views.PokemonView;
import org.apache.commons.cli.*;

/**
 * The main class of the Pokédex application responsible for fetching Pokémon data, creating views,
 * and displaying the information in various output formats.
 */
public class Pokedex {

    private static DataSource dataSource = DataSource.WEB_API;
    private static OutputFormat outputFormat = OutputFormat.TEXT;
    private static Long pokemonId;
    private static String databasePath = "pokemondatabase.sqlite";
    private static Pokemon pokemon;

    /**
     * The main entry point for the Pokédex application.
     *
     * @param args Command line arguments passed to the application.
     * @throws ParseException                    If there is an error parsing the command line arguments.
     */
    public static void main(String[] args) throws ParseException {
        PokemonView pokemonView;
        SQLData sqlData;
        HTTPData httpData;
        /* Parse the command line arguments, this is done for you, keep this code block */
        try {
            parseCommandLineArguments(args);
        } catch (PokemonCommandLineParsingException e) {
            System.err.println(e.getMessage());
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("./Pokedex <PokemonId> [-d|--database <databaseFile>] [-f|--format <format>]", e.getOptions());
            System.exit(0);
        }

        /*
        * Gather the data
        */
        if (dataSource == DataSource.WEB_API) {
            httpData = new HTTPData();
            httpData.getData((long) pokemonId);
            pokemon = httpData.createPokemon();
        } else if (dataSource == DataSource.LOCAL_DATABASE) {
            sqlData = new SQLData(databasePath);
            sqlData.getData((long) pokemonId);
            pokemon = sqlData.createPokemon();
        }

        /*
        * Create the view of the Pokémon
        */
        pokemonView = new PokemonView(pokemon);

        /*
        * Write to the console
        */
        ConsoleOutputUtility consoleOutputUtility = new ConsoleOutputUtility(outputFormat, pokemonView);
        consoleOutputUtility.makeOutput();
    }

    /**
     * Parses the command line arguments to set the appropriate values for data source, output format,
     * Pokémon ID, and database path.
     *
     * @param args The command line arguments passed to the application.
     * @throws PokemonCommandLineParsingException If there is an issue with the Pokémon command line parsing.
     * @throws ParseException                    If there is an error parsing the command line arguments.
     */
    public static void parseCommandLineArguments(String[] args) throws PokemonCommandLineParsingException, ParseException {
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();
        options.addOption("d", "database", true, "Path to a SQLite database containing pokémons");
        options.addOption("f", "format", true, "Specify the output format, between 'text', 'html' and 'csv'. By default 'text'.");

        // parse the command line arguments
        CommandLine line = parser.parse(options, args);
        if (line.hasOption("d")) {
            dataSource = DataSource.LOCAL_DATABASE;
            databasePath = line.getOptionValue("d");
        }

        if (line.hasOption("f")) {
            String formatArgValue = line.getOptionValue("f");
            switch (formatArgValue) {
                case "html":
                    outputFormat = OutputFormat.HTML;
                    break;
                case "csv":
                    outputFormat = OutputFormat.CSV;
                    break;
                case "text":
                    outputFormat = OutputFormat.TEXT;
                    break;
                default:
                    throw new PokemonCommandLineParsingException("Invalid value for the option -f/--format", options);
            }
        }

        // Get Pokémon ID from remaining arguments
        String[] remainingArgs = line.getArgs();
        if (remainingArgs.length < 1) {
            throw new PokemonCommandLineParsingException("You must provide a pokemon ID", options);
        }
        try {
            pokemonId = (long) Integer.parseInt(remainingArgs[0]);
        } catch (NumberFormatException e) {
            throw new PokemonCommandLineParsingException("'" + remainingArgs[0] + "' is not a valid pokemon ID", options);
        }
    }

    /**
     * Custom exception class for handling Pokémon command line parsing issues.
     */
    static class PokemonCommandLineParsingException extends Exception {

        private Options options;

        /**
         * Constructs a PokemonCommandLineParsingException with the specified message and options.
         *
         * @param msg     The error message.
         * @param options The command line options.
         */
        public PokemonCommandLineParsingException(String msg, Options options) {
            super(msg);
            this.options = options;
        }

        /**
         * Gets the command line options associated with the exception.
         *
         * @return The command line options.
         */
        public Options getOptions() {
            return options;
        }

    }
}
