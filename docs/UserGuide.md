---
layout: page
title: User Guide for A Caring Book (TP T12-2)
---

A Caring Book is a **desktop app designed for Patient Care Coordinators to manage patient and staff contact details efficiently.** 
Optimized for use via a Command Line Interface (CLI) while retaining the benefits of a Graphical User Interface (GUI), 
A Caring Book enables faster contact management compared to traditional GUI apps, especially for users who type quickly.

Unlike conventional systems that require manual entering of details for each category (e.g. Name, Phone, Department),
A Caring Book streamlines the process with `addpatient` and `addstaff` commands. Filtering commands such as 
`find`, `findstaff` and `finddep` allow for quick lookup, particularly in emergency situations, making contact management more efficient.
A Caring Book also employs the use of shortcut commands, which further elevates the user experience. 

* Table of Content
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `17` or above installed in your Computer. To check for your local Java version, 
open a command terminal, type `java --version` and press Enter.<br>
   **Mac users:** Ensure you have the precise JDK version prescribed [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).

1. Download the latest `.jar` file from [here](https://github.com/AY2425S2-CS2103T-T12-2/tp/releases/tag/v1.3).

1. Copy the file to the folder you want to use as the _home folder_ for your A Caring Book app.

1. In the command terminal, `cd` into the folder you put the jar file in, and use the `java -jar acaringbook.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

2. You can toggle between Light and Dark mode by clicking on "File" in the top left corner of the app window, and select
or deselect the option "Dark Mode".

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:


   * `liststaff` : Lists all staffs.

   * `listpatient` : Lists all patients.

   * `list` : Lists all contacts.

   * `addstaff r/doctor n/Mary Jane p/9929126 e/maryJ@example.com a/Spider street, block 333, #03-03` : Adds a doctor named `Mary Jane` to the Address Book.

   * `addpatient n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 dr/Dr Mak nn/Mrs Doe dp/Conology` : Adds a patient named `John Doe` to the Address Book.

   * `remark 3 rm/Needs wheelchair` : Remarks that the 3rd contact shown in the current list needs a wheelchair.

   * `delete 3` : Deletes the 3rd contact shown in the current list.

   * `toggle-theme` : Toggles between light and dark mode.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `addpatient n/NAME`, `NAME` is a parameter which can be used as `addpatient n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [e/EMAIL]` can be used as `n/John Doe e/JohnDoe@gmail.com` or as `n/John Doe`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE`, `p/PHONE n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

### Adding a patient: `addpatient`

Adds a patient to the address book.

Format: `addpatient n/NAME p/PHONE [e/EMAIL] [a/ADDRESS] [dr/DOCTOR_IN_CHARGE] [nn/NOK_NAME] [np/NOK_PHONE] [dp/DEPARTMENT]​`

Examples:

* `addpatient n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 dr/Dr Mak nn/Mrs Hong Doe np/98721322 dp/Conology`
* `addpatient n/Betsy Crowe e/betsycrowe@example.com a/Newgate Prison p/1234567 dr/Dr Teo nn/Mr Bui Crowe np/98268642 dp/Conology`

### Adding a staff: `addstaff`

Adds a staff to the address book.

Format: `addstaff [r/ROLE] n/NAME p/PHONE [dp/DEPARTMENT] [e/EMAIL] [a/ADDRESS]​`

Examples:
* `addstaff r/doctor n/Mary Jane dp/General Surgery p/9929126 e/maryJ@example.com a/Spider street, block 333, #03-03`
* `addstaff r/nurse n/Mark Markerburg dp/Emergency p/99137653 e/theMUCK@example.com a/Zaney street, block 666, #01-06` 

### Listing all persons : `list`

Shows a list of all persons in the address book.

Format: `list`

### Listing all patients : `listpatient`

Shows a list of all patients in the address book.

Format: `listpatient`

### Listing all staffs : `liststaff`

Shows a list of all staff in the address book.

Format: `liststaff`

### Editing a person : `edit`

Edits an existing person in the address book.

Format: `edit INDEX [r/role] [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [do/DOCTOR_IN_CHARGE] [nn/NOK_NAME] [np/NOK_PHONE] [dp/DEPARTMENT]`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* Role field is only available for healthcare staff, doctor_in_charge, nok_name, nok_phone and department fields are only avaliable for patients.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.

### Locating persons by name: `find`

Finds persons whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Partial words will be matched e.g. `Han` will match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `find John` returns `john` and `John Doe`
* `find alex charlotte` returns `Alex Yeoh`, `Charlotte Oliveiro`<br>
  ![result for 'find alex charlotte'](images/findAlexCharlotteResult.png)


### Locating a contact by department: `finddep`

Find patients whose departments match with the keyword.

Format: `finddep KEYWORD`

* The search is case-insensitive. e.g `Conology` will match `conology`
* Only one keyword is allowed.
* Only the department of the contact is searched.
* Partial words will be matched e.g. `con` will match `conology`.
* All contacts in the department will be returned e.g. `finddep conology` will return a list of Conology patients and doctors.

Examples:
If these two `addpatient` commands are executed,
* `addpatient n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 dr/Dr Mak nn/Mrs Hong Doe dp/Conology`
* `addpatient n/Betsy Crowe e/betsycrowe@example.com a/Newgate Prison p/1234567 dr/Dr Teo nn/Mr Bui Crowe dp/Conology`

then
* `finddep conology` returns `John Doe` and `Betsy Crowe`.

### Locating a healthcare provider by role: `findstaff`

Find healthcare staff whose roles matches with the keyword.

Format: `findstaff KEYWORD`

* The search is case-insensitive. e.g `Doctor` will match `doctor`
* Only one keyword is allowed. 
* Only the role of the healthcare provider is searched.
* Partial words will be matched e.g. `doc` will match `doctor`.
* All healthcare staff matching the role will be returned e.g. `findstaff doctor` will return a list of all doctors.

Examples:
If these two `addstaff` commands are executed, 
* `addstaff r/doctor n/Mary Jane p/9929126 e/maryJ@example.com a/Spider street, block 333, #03-03`
* `addstaff r/nurse n/Mark Markerburg p/99137653 e/theMUCK@example.com a/Zaney street, block 666, #01-06`

then 
* `findstaff doctor` returns `Mary Jane`
* `findstaff nurse` returns `Mark Markerburg`.

### Adding remark to a person : `remark`

Adds or updates the remark of the specified person from the address book.

Format: `remark INDEX rm/REMARK`

* Adds or updates the remark of the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `remark 2 rm/Needs wheelchair` updates the 2nd person in the address book.
* `find Betsy` followed by `remark 1 rm/Banana allergy` updates the 1st person in the results of the `find` command.
* `remark 3 rm/` clears the remark for the 3rd person.

### Deleting a person : `delete`

Deletes the specified person from the address book.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

### Toggle between light and dark mode : `toggle-theme` or `tt`

Toggles between light and dark mode theme based on user preference.

Format: `toggle-theme` or `tt`

### Clearing all entries : `clear`

Clears all entries from the address book.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the AddressBook to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</div>

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add Patient** | `addpatient n/NAME p/PHONE [e/EMAIL] [a/ADDRESS] [do/DOCTOR_IN_CHARGE] [nn/NOK_NAME] [np/NOK_PHONE] dp/DEPARTMENT]​` <br> e.g., `addpatient n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 dr/Dr Mak nn/Mrs Ho dp/Conology`
**Add Staff** | `addstaff [r/ROLE] n/NAME [dp/DEPARTMENT] p/PHONE [e/EMAIL] [a/ADDRESS]​` <br> e.g., `addstaff r/doctor n/James Ho dp/Internal Medicine p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit** | `edit INDEX [r/ROLE] [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [do/DOCTOR_IN_CHARGE] [nn/NOK_NAME] [np/NOK_PHONE] [dp/DEPARTMENT]​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Find By Name** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**Find By Department** | `finddep KEYWORD`<br> e.g., `finddep surgery`
**Find Staff By Role** | `findstaff KEYWORD`<br> e.g., `findstaff nurse`
**List** | `list`
**List Patients** | `listpatient`
**List Staff** | `liststaff`
**Help** | `help`
**Remark** | `remark 1 rm/Banana allergy`
**Toggle theme** | `toggle-theme` or `tt`
