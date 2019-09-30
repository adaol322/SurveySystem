import { Questions } from './questions';

export class Answers {
    idAnswers?: BigInteger;
    answer: string;
    questionDTO: Questions;

    constructor(answer: string, questionDTO: Questions) {
        this.answer = answer;
        this.questionDTO = questionDTO;
    }
}
