[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/x6ckGcN8)
# 3500 PA05 Project Repo

[PA Write Up](https://markefontenot.notion.site/PA-05-8263d28a81a7473d8372c6579abd6481)

# Notes:
- The password for the journal is password123
- We added partial images of the UML (as UMLpt1, UMLpt2, UMLp3) because it's too big for the grader to see.

# Screenshot of Week GUI View: doesn't allow us to paste an image here, attached in project repository in main directory (along with UML)

# Pitch
Do you ever just want a space to write down all the tasks and events that pile up every week? 
Well, our bullet journal program lets you do just that! It lets you stay on track and plan 
out all those important tasks you've been needing to do or those events you can't wait to attend!
The features, including a view of the whole week, the ability to create and add new events and tasks to 
your weekly schedule, getting warnings to not exceed the maximum amount of events and tasks (that you can set
on your own), and the ability to save your information to a file or even open a new file and add that data 
to your journal, are only some of the ways you can customize your bujo journal to fit your needs and make sure 
you never miss a task or an event again! Some other cool features of our bujo journal that will 
also help you stay on top of your commitments are a task queue that shows all your tasks 
for the week in one place and shows their completion status, some menu-bar
shortcuts, to easily create a new task, save a file, open a file, create a new week, change the
day you would like the week to start on (either Sunday or Monday), and change the maximum number of tasks and
events you want to schedule per day, just with a click on your keyboard. Additionally, you 
can keep track of the total number of events and tasks scheduled per week and 
the percentage of tasks completed at a given time. You can even keep track of
your tasks planned per day versus how many are completed, through a progress bar! Other fun features of 
our bujo journal program include an area to keep any extra notes or those motivational quotes getting you 
through the week, the ability to personalize the layout, to either horizontal or vertical,
and being able to change the start day of the week! Also, you can't forget about the privacy lock that prevents
people from just getting into your journal without your permission. We can't wait for you to use this beautiful 
bujo journal that will always help you keep track of your commitments and be more productive!

# SOLID Principles
- Single Responsibility Principle: Throughout our project, we followed the single responsibility principle by ensuring 
that each class had a single responsibility. This meant that our classes had one purpose that did not overlap with other 
classes responsibility. We applied this principle to our methods as well, ensuring that methods each had a single
specific task to complete, instead of larger broad purposes. For example, there were several instances in our code
where we had to make changes for each of the days in the week. Instead of having a method responsible for doing all the 
work within one method, we called helper methods that did the method on the day specifically. This allowed our code to 
be concise and easy to follow.

- Open/Closed Principle: We implemented the open/closed principle by creating interfaces. This allowed our code to be open
for extension but closed for modification since we incorporated interfaces in our design. This allows us to make 
classes that implement these interfaces, so we can use it for certain purposes. This gives us the freedom to create other
classes that implement the same interface if we want to incorporate other functionality. An example of this in our code,
is the Journal Interface. We created a BulletJournal class that implements this interface for the purpose of creating a 
Bullet Journal view. If we wanted to have a different kind of Journal, our program gives us the flexibility to do so.

- Liskov Substitution Principle: We also followed the Liskov Substitution Principle which states that objects of a 
superclass should be able to be replaced by objects of its subclass without creating errors or breaking the program. 
An example of this in our code is the JournalController having a JournalInterface field rather
than a BulletJournal field. Even though for the duration of this project, we only used a BulletJournal, we kept it as 
JournalInterface for the sake of flexibility and extensibility of our program in the future. Throughout the program, we
made sure than any method calls on the journal were public methods in the interface, not specific to the BulletJournal
class. This allows us to replace BulletJournal with another subclass that implements JournalInterface without breaking 
the program.  

- Integration Segregation Principle: We also followed the Integration Segregation Principle outlined by the SOLID 
principles. According to this principle, there should not be instances where parts of our code is forced to depend on
interfaces we don't use. This is why we had specific interfaces like the Controller Interface that was specifically made
to interact with a JournalInterface and GuiViewInterface. Instead of having large, general interfaces responsible for 
several things within our code, we created interfaces with specific purposes so certain code that relied on interfaces 
were not also dependent on several other responsibilities.

- Dependency Inversion Principle: The Dependency Inversion Principle states that high level classes should not rely on
low level classes, but should instead rely on abstractions. We incorporated this principle in our code by ensuring that
we made references to interfaces whenever possible instead of specific subclasses. For example, as mentioned above,
our JournalController had a JournalInterface object, rather than a BulletJournal object. This allowed for the 
BulletJournal to be easily replaceable with other classes that implement JournalController. Since we followed the Liskov
Substitution Principle and did not call to classes specifically within BulletJournal, replacing it with another subclass 
of JournalController would be simple and wouldn't create issues in our code. Using the Dependency Inversion Principle 
has allowed for greater flexibility in the future for substituting these subclasses with other subclasses of the same
superclass. 

# How we could extend our program to add a feature:
One of the features we did not implement in our program was Custom Themes. This functionality could have been added
by creating a button called changeTheme that opens a change theme popup. On the popup the user could choose from 
different theme options with varying colors, fonts, etc. This we would have implemented similar to the same way we
created popups for other functionality in our program like creating tasks and events and saving to a file. Then we could
have added the functionality of actually changing the display by editing the fxml file. We could have change the 
background color of various containers like the task queue container and the vbox/hbox containing the list
of events and tasks for the day. We could have even changed the font of different text labels in the journal.
This would all be done programmatically. Otherwise, we could have created multiple fxml files with different themes
and loaded new fxml files when the user chooses a specific theme.

# Design Documentation: Here are some of the design choices we made for our program.
We implemented a password lock for our journal. The password is password123.

Since we allow the user to specify maxEvents/maxTasks anytime, we automatically set the default maxEvents and maxTasks
to 100 for both if the user has not specified a max yet.

The keyboard commands we chose to use are:
 - Create New Event: cmd/ctrl + e
 - Create New Task: cmd/ctrl + t
 - Save to file: cmd/ctrl + s
 - Open: cmd/ctrl + o
 - New Week: cmd/ctrl + n
 - Change Start Day: cmd/ctrl + d
 - Change Max events/tasks: cmd/ctrl + m

We also made it so tasks are unable to be changed from the task queue but their status can be seen.
