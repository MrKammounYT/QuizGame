# Quiz Game (1.18.2)

If you're a Minecraft player looking for a fun and interactive way to challenge your friends or test your knowledge, the Quiz plugin is just what you need. With this plugin, you can create quizzes for different categories and customize the questions to your liking. The configuration file allows you to add new categories and questions as you please, giving you complete control over the quiz content. And the best part? For every correct answer, players will earn a point, making it an exciting competition. To ensure that player points are accurately tracked and stored, the plugin uses SQL, providing a reliable and efficient system for scorekeeping. With the Quiz plugin, you can bring a new level of engagement to your Minecraft gameplay, while also enhancing your knowledge and learning new facts along the way.


# how to install ?
Installing the Quiz plugin for Minecraft is a simple process. Follow these steps to get started:

- Download the Quiz plugin.

- Once downloaded, locate the Quiz plugin file and move it to your Minecraft server's plugin folder. This folder can typically be found in your server's main directory under the "plugins" folder.
- Next, you'll need to configure your MariaDB database to work with the plugin. Open the configuration file for your MariaDB database and make any necessary changes to ensure that the plugin can connect to the database.
- After configuring the database, open the Quiz plugin's configuration file and begin editing the categories and questions to your liking. You can add new categories and questions, as well as edit existing ones to better fit your gameplay preferences.
- Finally, start your Minecraft server and enjoy playing the Quiz plugin with your friends or fellow players.
By following these simple steps, you'll be able to quickly and easily install the Quiz plugin, customize it to your liking, and start playing right away.


## Commands:

 + `/quiz start [category]` This command allows players to start the quiz game and select a specific category to play.
| For example, "/quiz start history" would start a quiz game with questions from the history category.

* `/quiz stop`  This command is used to stop the quiz game if a player is currently in one. 
| It can be entered at any time during the quiz game to end the current game and return players to the normal gameplay mode.

* `/quiz points` this allows the player to see the total points he gained from answering quiz's
| It can be entered at any time during the quiz game and will send a message to the player

## Permessions:
* `quiz.use`
| this Permession allows the player to start and quit a quiz

