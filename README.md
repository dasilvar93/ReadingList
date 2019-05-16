# ReadingList

This is a project that I started through a suggestion from a friend in the PhD program in philosophy at UBC. He wanted an app that would allow him to keep track of all the readings he has to do: for classes, for courses he is teaching, for his own research, and for general interest. The end goal was to have an app that could be paired with citation management software, such as Mendeley or Zotero. This is the start of that process. Currently the goal is to get the app working independently of any citation software, then to explore how that connection can be made. 


### Current Status 

The project is written entirely in Java, although I am currently learning more JavaScript, and technologies like React and Meteor, so I may include more JavaScript in the future. Java UI is particularly limited, so I am looking for a feasible alternative. The current state of the project is that the data has been designed and implemented. The remaining work is to finish the UI, and to complete the citation parser. The citation parser allows the user to quickly add a reading to the list using only a citation. The program will read the citation and then create a new reading; populating the relevant fields with information extracted from the citation. The citation parser is tricky due to the variation across citations. Due to the difficulty of citation parsing, I have started to reconsider some design choices. Specifically, I am looking to simplify some of the data. Currently the data is more complex than is necessary for the use that the app initially has. Right now there is a dedicated Author class, with fields for their associated work, their affiliation, and name. The original intention was to be able to filter for a particular authors work, but in discussion with potential users it turns out that isn’t a very useful feature. Most users already have citation software which allows for this filtering and sorting, and so this feature would be redundant. So I am currently considering redesigning so that the Reading class takes a general description which would include author name and title, but not an Author class. 

### Completion 


The project is almost complete and I plan to have a working version completed by the end of May 2019. I plan to continue to work on it after that. Potential updates include: improving the citation parser, creating a web/mobile version of the app using JavaScript. 
