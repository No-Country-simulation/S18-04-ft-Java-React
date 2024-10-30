import 'server-only';
import { getCurrentUser } from './auth';
import { decodePayload } from './decodedToken';

export function hasAccess(slug, fallback = '') {
  const user = getCurrentUser();
  const decoded = decodePayload(fallback);
  const id = user?.id || decoded?.userId;
  return id === slug;
}

export function isFirstAccess(slug) {
  const user = getCurrentUser();
  return user && user?.isFirstSignin;
}

export function hasUser() {
  const user = getCurrentUser();
  return !!user;
}
