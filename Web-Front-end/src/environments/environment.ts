// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

const api: string = 'http://localhost:8080';
const resource: string = '/agenda/corporativa/api/v1/'

export const environment = {
  production: false,
  URL_BASE_BACKEND: `${api}`,
  API: {
    EVENTOS: {
      ELIMINAR: `${api}${resource}eventos/eliminar/`,
      GUARDAR: `${api}${resource}eventos/guardar`,
      OBTENER: `${api}${resource}eventos/obtener`,
      OBTENER_BY_ID: `${api}${resource}eventos/obtener/`,
      ACTUALIZAR: `${api}${resource}eventos/actualizar`
    },
    PARTICIPANTES: {
      ELIMINAR: `${api}${resource}participantes/eliminar/`,
      GUARDAR: `${api}${resource}participantes/guardar`,
      OBTENER: `${api}${resource}participantes/obtener`,
      OBTENER_BY_ID: `${api}${resource}participantes/obtener/`,
      ACTUALIZAR: `${api}${resource}participantes/actualizar`
    },
    INVITACION: {
      ELIMINAR: `${api}${resource}eventos-as-participantes/eliminar/`,
      GUARDAR: `${api}${resource}eventos-as-participantes/guardar`,
      OBTENER: `${api}${resource}eventos-as-participantes/obtener`,
      OBTENER_BY_ID: `${api}${resource}eventos-as-participantes/obtener/`,
      OBTENER_BY_ID_EVENTO: `${api}${resource}eventos-as-participantes/obtener/participantes/`,
      ACTUALIZAR: `${api}${resource}eventos-as-participantes/actualizar`
    }
  }

};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
