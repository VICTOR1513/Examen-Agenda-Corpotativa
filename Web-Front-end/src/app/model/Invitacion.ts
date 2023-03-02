import { Eventos } from './eventos';
import { Participantes } from './Participantes';
export class Invitacion {

  id!: number;
  idParticipante!: Participantes;
  idEvento!: Eventos;
  asistencia!: boolean;
  estatusAsistencia!: string;
}
