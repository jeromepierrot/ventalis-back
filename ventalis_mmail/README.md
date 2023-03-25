# Read Me First
This project is part of Ventalis project (back-end microservice).

Though, this "microservice" is actually not a real one : it's supposed to work as a standalone part and should NOT interact with other micro-services, nor their gateway : 

- It's a simple mail server. It will get the contact form request from the website's contact page, then filter and format it into a standard email, and finally send it through SMTP to a temporary mailbox.
- This temporary mailbox will then redirect to the actual contact mailbox (or other carbon copy).
- So, it's supposed to work as a standalone part and should NOT interact with other micro-services nor gateway.
- Also, by nature, it does not hold or iteract with any database.

Note : the mail server ('mmail') is in progress too (not tested yet), and is part of the 1st round of dev's cycle too.

*The main reason to detach this  service are :
- to prevent any attack from non-secured endpoint. The mail server will filter messages, then forward them a main contact mailbox.
  This main mailbox can also filter again and then redirect to the actual mailbox (let say 'contact@ventalis.fr').
- there is no direct contact email text stored on the website's public pages themselves.
- 'mmail' doesn't have any database under the hood neither. So no persistent datas will be stored by this service and, therefore, no data to steal and/or to be protected against any attacking.

For full Getting started instructions, please see the global project's [README.md file](../README.md).

The website (front-end) part of the project is stored in another Git repositories :
https://github.com/jeromepierrot/ventalis-front

# Getting Started
To run this module on a development environment and as standalone application.

    This section is not fully edited yet. Please come back later for any update

# Functional details

    This section is not fully edited yet. Please come back later for any update

