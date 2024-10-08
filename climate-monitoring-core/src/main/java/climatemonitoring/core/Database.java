/*

Alessandro della Frattina 753073 VA
Cristian Capiferri 752918 VA
Francesco Lops 753175 VA
Dariia Sniezhko 753057 VA

*/

package climatemonitoring.core;

/**
 * The database interface is responsible for communication between the application
 * and the database. It allows to perform specific operations, but not to execute
 * new SQL queries. Every operation should throw ConnectionLostException if the client
 * loses connection to the server during the operation and DatabaseRequestException if
 * the database fails to process the given request
 * 
 * @author ccapiferri
 * @version 1.0-SNAPSHOT
 */
public interface Database {

	/**
	 * To start a transaction
	 * 
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public void begin() throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To end a transaction
	 * 
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public void end() throws ConnectionLostException, DatabaseRequestException;


	/**
	 * Returns in alphabetical order an array of areas which have a name that
	 * contains the input string.
	 * 
	 * For example, if the given string is 'var' then
	 * the output would be an array like this:
	 * 
	 * {
	 * 	"Varese",
	 * 	"Novarese",
	 * 	"Isola Dovarese",
	 * 	...
	 * }
	 * 
	 * @param str The input string the search is based on
	 * @return The result of the search as an array of areas
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Area[] searchAreasByName(String str) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * Returns in alphabetical order an array of areas which belong
	 * to the country whose name contains the input string
	 * 
	 * @param str The input string the search is based on
	 * @return The result of the search as an array of areas
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Area[] searchAreasByCountry(String str) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * Returns in alphabetical order an array of areas which can be
	 * found around the specified coordinates. The around is about 0.5
	 * degrees for both latitude and longitude
	 * 
	 * @param latitude Value between -90 and 90
	 * @param longitude Value between -180 and 180
	 * @return The result of the search as an array of areas
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Area[] searchAreasByCoords(double latitude, double longitude) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * Returns in alphabetical order an array of centers which have
	 * a name that contains the input string
	 * 
	 * For example, if the given string is "var" then the output
	 * would be an array like this:
	 * 
	 * {
	 * 	"Centro di Varese",
	 * 	"Centro di Novarese",
	 * 	"Centro di Isola Dovarese",
	 * 	...
	 * }
	 * 
	 * @param str The input string the search is based on
	 * @return The result of the search as an array of centers
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Center[] searchCentersByName(String str) throws ConnectionLostException, DatabaseRequestException;


	/**
	 * To get an area by its geoname id
	 * 
	 * @param geoname_id The geoname id of the area to be searched
	 * @return The area that corresponds to the given geoname id
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Area getArea(int geoname_id) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To get all the areas monitored by a specified center
	 * 
	 * @param center_id The id of the center the search is based on
	 * @return The areas monitored as an array of areas
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Area[] getMonitoredAreas(String center_id) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To get a center by its center id
	 * 
	 * @param center_id The center id of the center to be searched
	 * @return The center that corresponds to the given center id
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Center getCenter(String center_id) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To get all the available centers
	 * 
	 * @return All the centers as an array of centers
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Center[] getCenters() throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To get a center based on its address
	 * 
	 * @param city The city the center is located in
	 * @param street The street the center is located in
	 * @param house_number The house number the center is located in
	 * @return The center that corresponds to the given address
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Center getCenterByAddress(int city, String street, int house_number) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To get the center with the most recent recording about the specified area
	 * 
	 * @param geoname_id The area's id
	 * @return The latest center that submitted a recording for the given area
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Center getLatestCenter(int geoname_id) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To get all the centers that monitor a specified area
	 * 
	 * @param geoname_id The id of the area the search is based on
	 * @return The centers associated as an array of centers
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Center[] getAssociatedCenters(int geoname_id) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To get an operator based on their user id
	 * 
	 * @param user_id The operator's ID
	 * @return The operator whose ID corresponds with the given one
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Operator getOperator(String user_id) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To get an operator based on their SSID
	 * 
	 * @param ssid The operator's SSID
	 * @return The operator whose SSID corresponds with the given one
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Operator getOperatorBySSID(String ssid) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To get an operator based on their email address
	 * 
	 * @param email The operator's email address
	 * @return The operator whose email address corresponds with the given one
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Operator getOperatorByEmail(String email) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * Returns an array containing parameters about a specified area that were recorded
	 * by the desired center about a specific category
	 * 
	 * @param geoname_id The area's ID
	 * @param center_id The center's ID
	 * @param category The parameter's category
	 * @return The result of the search as an array of parameters
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Parameter[] getParameters(int geoname_id, String center_id, String category) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To get the average about the score of a specific area,
	 * of a specific center about a specific category
	 * 
	 * @param geoname_id The area's ID
	 * @param center_id The center's ID
	 * @param category The parameter's category
	 * @return The average of the scores as a double
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public double getParametersAverage(int geoname_id, String center_id, String category) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * Get all the categories and their explanation
	 * 
	 * @return An array of all categories with relative descriptions
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Category[] getCategories() throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To get the category with the most recent recording about the specified area in the specified center
	 * 
	 * @param geoname_id The area's ID
	 * @param center_id The center's ID
	 * @return The latest category of the given center for the given area
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Category getLatestCategory(int geoname_id, String center_id) throws ConnectionLostException, DatabaseRequestException;


	/**
	 * Adds an area to the database
	 * 
	 * @param area The area that needs to be added to the database
	 * @return Success or failure of the operation
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public boolean addArea(Area area) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * Adds a center to the database
	 * 
	 * @param center The center that needs to be added to the database
	 * @return Success or failure of the operation
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public boolean addCenter(Center center) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * Adds an operator to the database
	 * 
	 * @param operator The operator that needs to be added to the database
	 * @return Success or failure of the operation
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public boolean addOperator(Operator operator) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * Adds a parameter to the database
	 * 
	 * @param parameter The parameter that needs to be added to the database
	 * @return Success or failure of the operation
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public boolean addParameter(Parameter parameter) throws ConnectionLostException, DatabaseRequestException;


	/**
	 * Edits an existing operator
	 * 
	 * @param user_id The ID of the operator that will get edited
	 * @param operator The new operator that will overwrite the previous one
	 * @return Success or failure of the operation
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public boolean editOperator(String user_id, Operator operator) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To add an existing area to a specified center
	 * 
	 * @param geoname_id The area to be added in the center
	 * @param center_id The center the area needs to be added in
	 * @return Success or failure of the operation
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public boolean includeAreaToCenter(int geoname_id, String center_id) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To check if a monitoring center is monitoring an area
	 * 
	 * @param center_id The ID of the center
	 * @param geoname_id The ID of the area
	 * @return True if the area is being monitored by a center, false otherwise
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public boolean monitors(String center_id, int geoname_id) throws ConnectionLostException, DatabaseRequestException;

	/**
	 * To check if a monitoring center is employing an operator
	 * 
	 * @param center_id The ID of the center
	 * @param user_id The ID of the operator
	 * @return True if an operator is being employed by a center, false otherwise
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public boolean employs(String center_id, String user_id) throws ConnectionLostException, DatabaseRequestException;


	/**
	 * Checks whether the userid and password are valid. If so, the corresponding
	 * operator will be returned, null otherwise
	 * 
	 * @param user_id Operator's user id
	 * @param password Operator's password
	 * @return The operator whose credentials correspond to the ones in input
	 * @throws ConnectionLostException If the client loses connection during the operation
	 * @throws DatabaseRequestException If the database fails to process the given request
	 */
	public Operator validateCredentials(String user_id, String password) throws ConnectionLostException, DatabaseRequestException;
}
