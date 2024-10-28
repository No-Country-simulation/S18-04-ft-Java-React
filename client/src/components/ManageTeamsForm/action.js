'use server';
import { getCurrentToken } from '@/data/auth';
import { validateSchema } from '@/lib/validateSchema';
import { manageTeamsSchema } from '@/schemas/manageTeamsSchema';
const baseURL = process.env.URL;

export async function manageTeams(_state, formData){
    const [error, data] = validateSchema(manageTeamsSchema, {
        eventNum: formData.get('eventNum'),
        scheduleNom: formData.get('scheduleNom'),
        frameworkFront: formData.get('frameworkFront'),
        frontQuantity: parseInt(formData.get('frontQuantity')),
        backQuantity: parseInt(formData.get('backQuantity')),
        qaQuantity: parseInt(formData.get('qaQuantity')),
        pmQuantity: parseInt(formData.get('pmQuantity')),
        uxQuantity: parseInt(formData.get('uxQuantity')),
    });
    if (error) return error;

    try {
        const token = getCurrentToken();
        const params = {
            eventNum: data.eventNum,
            scheduleNom: data.scheduleNom,
            frameworkFront: data.frameworkFront,
            frontQuantity: data.frontQuantity,
            backQuantity: data.backQuantity,
            qaQuantity: data.qaQuantity,
            pmQuantity: data.pmQuantity,
            uxQuantity: data.uxQuantity,
        };
        const payload = {
            method: 'POST',
            headers: { Cookie: `token=${token}` },
            credentials: 'include',
        };

        const res = await
            fetch(`${baseURL}/api/event-records/update-assigned-records?${new URLSearchParams(params)}`, payload);

        if (!res.ok) {
            const errorResponse = await res.text();
            console.error({ message: 'Error al asignar los equipos.', details: { errorResponse } });

            return {
                id: crypto.randomUUID(),
                status: 'FETCH_ERROR',
                errors: { GLOBAL: 'Error al asignar los equipos.' },
            };
        } else {
            return {
                id: crypto.randomUUID(),
                status: 'FETCH_ERROR',
                data: await res.text(),
            };
        }
    } catch (err) {
        console.error({
            message: `Se ha producido un error inesperado: ${err.message}`,
            details: { err },
        });

        return {
            id: crypto.randomUUID(),
            status: 'FETCH_ERROR',
            errors: { GLOBAL: 'Se ha producido un error inesperado' },
        };
    }
}