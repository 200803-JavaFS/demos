export class Todo {
    id:number;
    title:string;
    createdOn:string;
    completed:boolean;

    constructor(id:number, title:string, createdOn:string, completed:boolean){
        this.id =id;
        this.title = title;
        this.createdOn = createdOn;
        this.completed = completed;    
        }

}
