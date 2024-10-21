import 'server-only';
import { getCurrentUser } from './auth';

export function hasAccess(slug) {
  const user = getCurrentUser();
  return user && user?.id === slug;
}

export function isFirstAccess(slug) {
  const user = getCurrentUser();
  return user && user?.isFirstSignin;
}

export function hasUser() {
  const user = getCurrentUser();
  return !!user;
}
