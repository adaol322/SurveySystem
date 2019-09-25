import { Questions } from './questions';

export interface Answers {
    idAnswers?: BigInteger;
    answer: string;
    question: Questions;
}
