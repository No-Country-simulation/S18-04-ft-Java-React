import { revalidatePath } from 'next/cache';
import { cookies } from 'next/headers';
import { redirect } from 'next/navigation';
import { NextResponse } from 'next/server';

export const maxDuration = 30;

export async function GET(req) {
  const cookieStore = cookies();
  cookieStore.delete('token');
  cookieStore.delete('USER');
  revalidatePath('/welcome');
  redirect('/welcome');

  return NextResponse.json({ response: 'Checkin' }, { status: 200 });
}
