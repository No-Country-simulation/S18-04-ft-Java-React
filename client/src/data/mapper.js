export const profileMapper = server => {
  return {
    id: server?.id || "",
    name: server?.profileName || "",
    lastname: server?.profileLastname || "",
    github: server?.githubUrl || "",
    linkedin: server?.linkedinUrl || "",
    avatar: server?.avatarUrl || "",
  };
};
