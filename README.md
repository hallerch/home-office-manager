# home-office-manager
Manage your home office day in an easy way
___
### Task 1 - Java delegate
Example in the code:
* Java class: EnoughFoodDelegate
* BPMN Activity: Check if you have enough food

[Camunda Documentation: Delegation Code][1]
___
### Task 2 - Service task to Manual Task
Difference between [Manual Task][2] and [User Task][3]
___
### Task 3 - User task with user interface
#### Version 1 - Generated Task Forms

In Camunda Modeler click on a User Task Activity.
Click on the tab 'Forms' and add a 'Form Field'. 

<img src="images/generated-task-form-1.png" width="500" alt="generated-task-form-1.png">

In Camunda go to the 'Tasklist' claim the user task and fill in the fields.

<img src="images/generated-task-form-2.png" width="500" alt="generated-task-form-2.png">

* [Camunda Documentation: Generated Task Forms][4]
#### Version 2 - Angular.js

Install **AngularJS** and the **Camunda BPM JS SDK** as dependencies into your project using *bower*:

Install *bower* through NPM with `npm install -g bower`

For **AngularJS**:

```bash
bower install angular#1.2.32 --save
```

For **Camunda BPM JS SDK**:

```bash
bower install camunda-bpm-sdk-js --save
```

On the given *User Task* in the **Camunda Modeler**, set the following value into the *Form Key* field:

`embedded:app:forms/your-form.html`

![Embedded Task Form with AngularJS](images/embedded-task-form-angularjs-1.png)

Now you should be able to use AngularJS functions and more in your embedded form.

Example in *angularjs-form.html*

```html
<form role="form" name="form">

    <label for="input-field">set to 'true' to buy some food</label><br>
    <input type="text"
           cam-variable-name="enoughFood"
           cam-variable-type="Boolean"
           ng-model="enoughFood"
           id="input-field">
    <p ng-show="enoughFood">
        Your input: <b>{{ enoughFood }}</b> <br>
        <sub>some sweet Two-Way Binding by AngularJS :o</sub>
    </p>

</form>
```

[Camunda Documentation: Embedded Task Forms][5]

[Standalone Usage of JS SDK with AngularJS][6]

#### Version 3 - Custom
In Camunda Modeler click on a User Task Activity.
Click on the tab 'Forms' and add in the 'Form Key' field 'app:forms/external-form.html'.

<img src="images/external-task-forms-1.png" width="500" alt="external-task-forms-1.png">

Check and understand the file src/main/webapp/forms/embedded-form.html

<img src="images/external-task-forms-2.png" width="500" alt="external-task-forms-1.png">

In Camunda go to the 'Tasklist' claim the user task and click on 'Open external form'

<img src="images/external-task-forms-3.png" width="500" alt="external-task-forms-2.png">

[Camunda Documentation: External Task Forms][7]

___
### Task 4 - Presentation
#### Difference between internal and external tasks
The process engine supports two ways of executing service tasks:
1. Internal Service tasks: Synchronous invocation of code deployed along with a 
	process application
2. External tasks: Providing a unit of work in a list that can be polled by workers

The first option is used when code is implemented as Delegation Code or as a Script. 
By contrast, external (service) tasks work in a way that the process engine publishes 
a unit of work to a worker to fetch and complete. We refer to this as the external 
task pattern.
___
### Literature and sources
* [Camunda Documentation: Delegation Code][1]
* [Camunda Documentation: Manual Task][2]
* [Camunda Documentation: User Task][3]
* [Camunda Documentation: Generated Task Forms][4]
* [Camunda Documentation: Embedded Task Forms][5]
* [Standalone Usage of JS SDK with AngularJS][6]
* [Camunda Documentation: External Task Forms][7]

[1]: https://docs.camunda.org/manual/latest/user-guide/process-engine/delegation-code/
[2]: https://docs.camunda.org/manual/7.8/reference/bpmn20/tasks/manual-task/
[3]: https://docs.camunda.org/manual/7.8/reference/bpmn20/tasks/user-task/
[4]: https://docs.camunda.org/manual/latest/user-guide/task-forms/#generated-task-forms
[5]: https://docs.camunda.org/manual/latest/user-guide/task-forms/#embedded-task-forms
[6]: https://github.com/camunda/camunda-bpm-examples/tree/master/sdk-js/browser-forms-angular
[7]: https://docs.camunda.org/manual/latest/user-guide/task-forms/#external-task-forms
