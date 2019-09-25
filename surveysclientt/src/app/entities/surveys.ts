import { LecturersDTO } from './lecturers';
import { Subjects } from './subjects';
import { Answers } from './answers';

export interface Surveys {
    idSurveys?: BigInteger;
    date: string;
    lecturer: LecturersDTO;
    subject: Subjects;
    answerList: Array<Answers>;
}
